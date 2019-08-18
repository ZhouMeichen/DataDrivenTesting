package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MiniStatementPage {
    @FindBy(how = How.XPATH, using = "//table[@class=\"layout\"]/tbody/tr[1]/td/p")
    WebElement title;
    
    @FindBy(how = How.ID, using = "ministmt")
    WebElement statementTb;
    
    public String[] getTableRow(String transactionId) {
        String[] result = null;
        List<WebElement> rows = statementTb.findElements(By.tagName("tr"));
        for (int i =1; i<rows.size()-1;i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            if (cells.get(0).getText().equals(transactionId)) {
                result = new String[cells.size()];
                for (int j =0;j<cells.size();j++) {
                    result[j] = cells.get(j).getText();
                }
                break;
            }
        }
        return result;
    }
}
