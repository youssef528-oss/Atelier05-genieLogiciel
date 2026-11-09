package fssm.ecommerce;

public class OrderService {
    private final PaymentProcessor paymentProcessor;
    private final OrderRepository orderRepository;

    public OrderService(PaymentProcessor paymentProcessor, OrderRepository orderRepository) {
        this.paymentProcessor = paymentProcessor;
        this.orderRepository = orderRepository;
    }

    public boolean processOrder(String orderId) {
        Order order = orderRepository.findById(orderId);
        
        if (order == null) {
            throw new IllegalArgumentException("Commande introuvable avec l'ID: " + orderId);
        }

        if (order.isPaid()) {
            return true; // Déjà payée
        }

        boolean success = paymentProcessor.processPayment(order.getId(), order.getAmount());

        if (success) {
            order.setPaid(true);
            orderRepository.save(order);
            return true;
        } else {
            throw new PaymentFailedException("Échec du paiement pour la commande : " + orderId);
        }
    }
}