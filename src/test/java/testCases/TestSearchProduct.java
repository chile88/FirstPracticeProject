package testCases;

import data.testdata.TestMessageData;
import data.testdata.TestSearchProductData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchPage;
import testbase.TestBase;

public class TestSearchProduct extends TestBase {
    MainPage objMainPage;
    SearchPage objSearchPage;

    @Test
    public void testSearchProduct() {
        // Create Main page
        objMainPage = new MainPage(driver);
        // Attempt to search product via search text
        objMainPage.searchProduct(TestSearchProductData.searchBlouse.getSearchText());
        // Create Search page
        objSearchPage = new SearchPage(driver);
        System.out.println(objSearchPage.getNumberOfResult());
        // Verify search results
        if (objSearchPage.getNumberOfResult() > 0) {
            //Assert all results contain search text
            Assert.assertTrue(objSearchPage.checkSearchResult(TestSearchProductData.searchBlouse.getSearchText()));
        }
        else {
            // Assert no results message is displayed
            Assert.assertTrue(objSearchPage.checkNoResultsMessage());
            // Assert no result message's content is displayed correctly
            Assert.assertTrue(objSearchPage.getNoResulstMessageContent().equals(TestMessageData.noResultMessage.getMessage()));
        }

    }
}
