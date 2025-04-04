package utilities;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;

public class S3Uploader {
    public static void uploadFile(String bucketName, String filePath, String keyName) {

        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

        s3Client.putObject(new PutObjectRequest(bucketName, keyName, new File(filePath)));

    }
}
