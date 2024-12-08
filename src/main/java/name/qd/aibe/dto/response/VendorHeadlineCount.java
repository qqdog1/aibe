package name.qd.aibe.dto.response;

import lombok.Data;

@Data
public class VendorHeadlineCount {
    private int count;
    private int total;

    public VendorHeadlineCount(int count, int total) {
        this.count = count;
        this.total = total;
    }
}
