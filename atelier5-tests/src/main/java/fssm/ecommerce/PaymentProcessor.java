package fssm.ecommerce;

public interface PaymentProcessor {
    boolean processPayment(String orderId, double amount);
}