package name.qd.aibe.dto.entity;

import lombok.Data;
import name.qd.aibe.constant.Vendor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
public class VendorUrl {
    @Id
    private String id;
    private Vendor vendor;
    private String url;
    private boolean isScanned;
    private Instant createTime;
    private Instant scanTime;
    private boolean isHeadlineNotMatch;
}
