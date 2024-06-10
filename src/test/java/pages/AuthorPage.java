package pages;

import org.openqa.selenium.By;

public class AuthorPage extends BasePage{
    public String authorPageUrl="https://www.wafilife.com/cat/books/author";
    public String authorPageTittle="English & Bangla Islamic Books by Authors | Wafilife";
    public By nextPageBtn=By.xpath("//a[contains(text(),'→')]");
    public By rajibulIslam=By.xpath("//h3[normalize-space()='Md. Rajibul Islam']");
}
