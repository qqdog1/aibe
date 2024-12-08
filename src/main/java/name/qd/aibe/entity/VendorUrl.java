package name.qd.aibe.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class VendorUrl {
    @Id
    private String id;
    private String vendor;
    private String url;
    private boolean isScanned;
}
