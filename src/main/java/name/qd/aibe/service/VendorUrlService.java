package name.qd.aibe.service;

import name.qd.aibe.constant.Vendor;
import name.qd.aibe.dto.entity.VendorUrl;
import name.qd.aibe.dto.response.VendorHeadlineCount;
import name.qd.aibe.repository.VendorUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendorUrlService {
    @Autowired
    private VendorUrlRepository vendorUrlRepository;

    private final Map<Vendor, VendorHeadlineCount> mapVendorCount = new HashMap<>();
    private List<VendorUrl> lstGoodLast3 = new ArrayList<>();
    private List<VendorUrl> lstBadLast3 = new ArrayList<>();

    @Scheduled(fixedDelay = 10000L)
    private void updateCache() {
        Instant lastUpdateTime = Instant.now();
        for (Vendor vendor : Vendor.values()) {
            int total = vendorUrlRepository.countByVendorAndScanTimeBefore(vendor, lastUpdateTime);
            int count = vendorUrlRepository.countByVendorAndScanTimeBeforeAndIsHeadlineNotMatch(vendor, lastUpdateTime, true);
            if (mapVendorCount.containsKey(vendor)) {
                VendorHeadlineCount vendorHeadlineCount = mapVendorCount.get(vendor);
                vendorHeadlineCount.setCount(count);
                vendorHeadlineCount.setTotal(total);
            } else {
                mapVendorCount.put(vendor, new VendorHeadlineCount(count, total));
            }
        }
        Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "scanTime"));
        lstBadLast3 = vendorUrlRepository.findByIsHeadlineNotMatch(true, pageable);
        lstGoodLast3 = vendorUrlRepository.findByIsHeadlineNotMatch(false, pageable);
    }

    public List<VendorUrl> getVendorUrl() {
        return vendorUrlRepository.findAll();
    }

    public void addVendorUrl(VendorUrl vendorUrl) {
        vendorUrlRepository.save(vendorUrl);
    }

    public Map<Vendor, VendorHeadlineCount> getHeadlineCount() {
        return mapVendorCount;
    }

    public List<VendorUrl> getGood() {
        return lstGoodLast3;
    }

    public List<VendorUrl> getBad() {
        return lstBadLast3;
    }
}
