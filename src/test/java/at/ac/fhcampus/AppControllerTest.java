package at.ac.fhcampus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    @Test
    void setArticles() {
        AppController test = new AppController();
        List<Article> testList1 = new ArrayList<Article>();
        testList1.add(new Article("Author1", "Title1"));
        testList1.add(new Article("Author2", "Title2"));
        testList1.add(new Article("Author3", "Title3"));
        testList1.add(new Article("Author4", "Title4"));
        List<Article> actual = test.getArticles();

        assertEquals(actual.size(),testList1.size());
        if(actual.size() == testList1.size()){
            int sizeList = actual.size();
            for(int k = 0; k < sizeList; k++){
                assertEquals(actual.get(k), testList1.get(k));
            }

        }

    }

    @Test
    void getArticleCount1() {
        AppController test = new AppController();
        int articleCount = 7;
        assertEquals(test.getArticleCount(), articleCount);
    }


    @Test
    void getTopHeadlinesAustria() {
        AppController test = new AppController();
        List<Article> actual = test.getTopHeadlinesAustria();

        List<Article> expected = new ArrayList<Article>();
        expected.add(new Article("Author1", "Austria1"));
        expected.add(new Article("Author2", "Austria2"));
        expected.add(new Article("Author3", "Austria3"));

        assertEquals(expected.size(), actual.size());
    }

    @Test
    void getAllNewsBitcoin() {
        AppController test = new AppController();
        List<Article> actual  = test.getAllNewsBitcoin();

        List<Article> expected = new ArrayList<Article>();
        expected.add(new Article("Author1","Bitcoin1"));
        expected.add(new Article("Author2","Bitcoin2"));

        assertEquals(expected.size(),actual.size());
    }

    @Test
    void filterListWithValidQuery() {
        try {
            final AppController controller = new AppController();
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertEquals(inputList, controller.filterList("SoMeThInG", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void filterListWithEmptyQuery() {
        try {
            final AppController controller = new AppController();
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertEquals(inputList, controller.filterList("", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void filterListWithQueryNotFoundInArticles() {
        try {
            final AppController controller = new AppController();
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertNotEquals(inputList, controller.filterList("Günther", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}