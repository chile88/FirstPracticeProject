package testCases;

import common.SetUp;
import data.testdata.TestEndToEndBuyProductData;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;





public class TestEndToEndBuyProducts extends SetUp {
    MainPage objMainPage;
    CategoryPage objCategoryPage;
    ProductPage objProductPage;
    CartProductPage objCartProductPage;
    SummaryPage objSummaryPage;
    AddressPage objAddressPage;
    ShippingPage objShippingPage;
    PaymentPage objPaymentPay;
    BankWirePaymentPage objBankWirePaymentPage;
    ConfirmationPage objConfirmationPage;
    MyAccountPage objMyAccountPage;
    OrderHistoryPage objOrderHistoryPage;

    @Test
    public void testBuyProducts() {
        // Login
        super.logIn();
        // Create Main page
        objMainPage = new MainPage(driver);
        // Hover on tab
        objMainPage.hoverTab(TestEndToEndBuyProductData.data1.getTabIndex());
        // Select category
        objMainPage.selectCategory(TestEndToEndBuyProductData.data1.getTabIndex(), TestEndToEndBuyProductData.data1.getCategoryName());
        // Go to Category page
        objCategoryPage = new CategoryPage(driver);
        // Select product, first hover on product then select "Quick View" button
        objCategoryPage.hoverProduct(TestEndToEndBuyProductData.data1.getProductIndex());
        objCategoryPage.selectQuickView(TestEndToEndBuyProductData.data1.getProductIndex());
        // Go to Product page
        objProductPage = new ProductPage(driver);
        // Switch to Product iframe
        objProductPage.switchToIframe();
        // Enter quantity wanted
        objProductPage.enterQuantityWanted(TestEndToEndBuyProductData.data1.getQuantityWanted());
        // Select size
        objProductPage.selectSize(TestEndToEndBuyProductData.data1.getSize());
        // Get product name
        String productName = objProductPage.getProductName();
        // Get Selected color
        String selectedColor = objProductPage.getSelectedColor();
        // Get Expected Price
        String expectedPrice = objProductPage.getPrice(Integer.parseInt(TestEndToEndBuyProductData.data1.getQuantityWanted()));
        // Select "Add to cart" button
        objProductPage.selectSubmitButton();
        // Switch back to default content
        driver.switchTo().defaultContent();
        // Go to CartProduct page
        objCartProductPage = new CartProductPage(driver);
        // Assert product name is displayed correctly
        Assert.assertTrue(objCartProductPage.getProductName().equals(productName));
        // Assert product attributes is displayed correctly
        Assert.assertTrue(objCartProductPage.getProductAttributes().equals(selectedColor + ", " +TestEndToEndBuyProductData.data1.getSize()));
        // Assert product price is displayed correctly
        Assert.assertTrue(objCartProductPage.getProductPrice().equals(expectedPrice));
        // Select ProceedToCheckOut button
        objCartProductPage.selectProceedToCheckOut();
        // Go to Summary page
        objSummaryPage = new SummaryPage(driver);
        // Assert product name is displayed correctly
        Assert.assertTrue(objSummaryPage.getProductName().equals(productName));
        // Assert product name is displayed correctly
        Assert.assertTrue(objSummaryPage.getProductAttributes().equals("Color : " + selectedColor + ", Size : " + TestEndToEndBuyProductData.data1.getSize()));
        // Assert total product price is displayed correctly
        Assert.assertTrue(objSummaryPage.getTotalProductPrice().equals(expectedPrice));
        // Assert total price after shipping and tax is displayed correctly
        Assert.assertTrue(objSummaryPage.checkTotalPrice());
        // Get total price
        String totalPrice = objSummaryPage.getTotalPrice();
        // Select ProceedToCheckOut button
        objSummaryPage.selectProccedToCheckOut();
        // Go to Address page
        objAddressPage = new AddressPage(driver);
        // Select ProccedToCheckOut button
        objAddressPage.selectProccedToCheckOut();
        // Go to Shipping page
        objShippingPage = new ShippingPage(driver);
        // Check on TermOfService check box and then select ProccedToCheckOut button
        objShippingPage.selectTermOfService();
        objShippingPage.selectProccedToCheckOut();
        //Go to Payment page
        objPaymentPay = new PaymentPage(driver);
        // Select pay by bank wire
        objPaymentPay.selectPaybyBankWire();
        // Go to BankWirePayment page
        objBankWirePaymentPage = new BankWirePaymentPage(driver);
        // Select ConfirmMyOrder button
        objBankWirePaymentPage.selectConfirmMyOrder();
        // Go to Confirmation page
        objConfirmationPage = new ConfirmationPage(driver);
        // Get the order reference
        String orderReference = objConfirmationPage.getConfirmCode();
        // Select customerAccount form Main Page
        objMainPage = new MainPage(driver);
        objMainPage.selectCustomerAccount();
        // Direct to My Account Page
        objMyAccountPage = new MyAccountPage(driver);
        objMyAccountPage.selectOrderHistory();
        // Direct to OrderHistory page
        objOrderHistoryPage = new OrderHistoryPage(driver);
        // Assert orderReference is displayed in the first line of order history
        Assert.assertTrue(objOrderHistoryPage.getData(0).getOrderReference().equals(orderReference));
        // Assert date is displayed correctly
        Assert.assertTrue(objOrderHistoryPage.compareToCurrentDate(0));
        // Assert total price is correctly
        Assert.assertTrue(objOrderHistoryPage.getData(0).getPrice().equals(totalPrice));
    }
}
