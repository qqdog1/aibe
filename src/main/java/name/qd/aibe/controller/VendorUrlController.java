package name.qd.aibe.controller;

import name.qd.aibe.entity.VendorUrl;
import name.qd.aibe.service.VendorUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendor")
public class VendorUrlController {
    private static final Logger logger = LoggerFactory.getLogger(VendorUrlController.class);
    @Autowired
    private VendorUrlService vendorUrlService;

    @GetMapping("")
    public ResponseEntity<List<VendorUrl>> getVendorUrl() {
        logger.info("Get call");
        List<VendorUrl> lst = vendorUrlService.getVendorUrl();
        return ResponseEntity.ok(lst);
    }

    @PostMapping("")
    public ResponseEntity<Void> addVendorUrl(@RequestBody VendorUrl vendorUrl) {
        vendorUrlService.addVendorUrl(vendorUrl);
        return ResponseEntity.ok().build();
    }
}
