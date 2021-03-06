package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

              // As you can see, this interface extends the JpaRepository interface from Spring Data JPA. JpaRepository defines
             // standard CRUD methods, plus JPA-specific operations
             // We don’t have to write implementation code because Spring Data JPA will generate necessary code at runtime, in form of proxy instances.
   // the purpose of writing the repository interface is to tell Spring Data JPA about the domain type (Product) and ID type (Long) to work with.