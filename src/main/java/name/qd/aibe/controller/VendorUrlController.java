package name.qd.aibe.controller;

import name.qd.aibe.constant.Vendor;
import name.qd.aibe.dto.entity.VendorUrl;
import name.qd.aibe.dto.response.VendorHeadlineCount;
import name.qd.aibe.service.VendorUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/headline/count")
    public ResponseEntity<Map<Vendor, VendorHeadlineCount>> getHeadlineCount() {
        return ResponseEntity.ok(vendorUrlService.getHeadlineCount());
    }

    @GetMapping("/headline/good")
    public ResponseEntity<List<VendorUrl>> getGood() {
        return ResponseEntity.ok(vendorUrlService.getGood());
    }

    @GetMapping("/headline/bad")
    public ResponseEntity<List<VendorUrl>> getBad() {
        return ResponseEntity.ok(vendorUrlService.getBad());
    }

    @GetMapping("/headline/goodBad")
    public ResponseEntity<Map<String, List<VendorUrl>>> getGoodBad() {
        Map<String, List<VendorUrl>> map = new HashMap<>();
        map.put("good", vendorUrlService.getGood());
        map.put("bad", vendorUrlService.getBad());
        return ResponseEntity.ok(map);
    }
}
