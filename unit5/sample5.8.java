public class CustomerController
{
  ...略

  public bool Purchase(int customerId, int productId, int quantity)
  {
    Customer customer = _customerRepository.GetBiId(customerId);
    Product product = _productRepository.GetById(productId);

    bool isSuccess = customer.Purchase(_mainStore, product, quantity);
    if (isSuccess)
    {
      _emailGateway.SendReceipt(customer.Email, product.Name, quantity, product.Price);
    }
    return isSuccess;
  }
}
