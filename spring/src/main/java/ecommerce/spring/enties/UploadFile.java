package ecommerce.spring.enties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UploadFile {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
