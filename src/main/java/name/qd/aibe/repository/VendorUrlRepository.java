package name.qd.aibe.repository;

import name.qd.aibe.constant.Vendor;
import name.qd.aibe.dto.entity.VendorUrl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface VendorUrlRepository extends MongoRepository<VendorUrl, String> {
    int countByVendorAndScanTimeBeforeAndIsHeadlineNotMatch(Vendor vendor, Instant scanTime, boolean isHeadlineNotMatch);
    int countByVendorAndScanTimeBefore(Vendor vendor, Instant scanTime);
    List<VendorUrl> findByIsHeadlineNotMatch(boolean isHeadlineNotMatch, Pageable pageable);
}
