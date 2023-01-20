package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;

import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    public List<Pedido> findAll();

    @Cacheable("books")
    List<Pedido> findByStatus(StatusPedido statusPedido, PageRequest pageRequest);

    @Query("select p from Pedido p join p.user where p.user.username = :username")
    List<Pedido> findAllByUser(@Param("username") String username);

    @Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
    List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);


    @Query("select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username")String username);}

