package fssm.ecommerce;

public interface OrderRepository {
    void save(Order order);
    Order findById(String id);
}