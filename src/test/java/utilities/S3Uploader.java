package utilities;
import io.github.cdimascio.dotenv.Dotenv;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;

public class S3Uploader {

    // Get keys from .env
    private static final Dotenv dotenv = Dotenv.load();
    private static final String accessKey = dotenv.get("ACCESS_KEY");
    private static final String secretKey = dotenv.get("SECRET_KEY");
    private static final String bucketName = dotenv.get("BUCKET_NAME");
    private static final Region region = Region.of(dotenv.get("REGION"));

    public static void uploadFileToS3(File file, String keyName) {
        S3Client s3 = S3Client.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)))
                .build();

        s3.putObject(PutObjectRequest.builder()
                .bucket(bucketName)
                .key(keyName).build(),
                file.toPath());
        s3.close();
    }
}
