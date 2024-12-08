package name.qd.aibe.service;

import name.qd.aibe.entity.VendorUrl;
import name.qd.aibe.repository.VendorUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorUrlService {
    @Autowired
    private VendorUrlRepository vendorUrlRepository;

    public List<VendorUrl> getVendorUrl() {
        return vendorUrlRepository.findAll();
    }

    public void addVendorUrl(VendorUrl vendorUrl) {
        vendorUrlRepository.save(vendorUrl);
    }
}
