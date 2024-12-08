package name.qd.aibe.repository;

import name.qd.aibe.entity.VendorUrl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorUrlRepository extends MongoRepository<VendorUrl, String> {
}
