import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.jupiter.api.Tag;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.link;
import static io.qameta.allure.Allure.step;

@Owner("zhuravel")
@Feature("Positive and negative cases of working with the main functionality of the Alyce service")
public class AlyceTests {
    private String baseUrl = "http://hrtest.alycedev.com/";
    private long timeout = 6000;
    private String errorMessageOddAndEvenIds = "You cant have apples with both odd and even ids, try again";
    private String errorMessageTimeout = "Basket cant give more than one apple per 5 sec";

    private SelenideElement userSection = $(".list-group"),
            basketSection = $(".basket"),
            jonathanSection = userSection.$(".list-group-item", 0),
            adrianSection = userSection.$(".list-group-item", 1),
            julieSection = userSection.$(".list-group-item", 2),
            jonathanAppleBadge = jonathanSection.$(".badge"),
            adrianAppleBadge = adrianSection.$(".badge"),
            julieAppleBadge = julieSection.$(".badge"),
            jonathanGrabButton = jonathanSection.$(".grab-apple"),
            adrianGrabButton = adrianSection.$(".grab-apple"),
            julieGrabButton = julieSection.$(".grab-apple"),
            jonathanAppleList = jonathanSection.$("ul"),
            adrianAppleList = adrianSection.$("ul"),
            julieAppleList = julieSection.$("ul"),
            freeApplesButton = $(".free-apples"),
            errorMessage = $(".alerts");

    @BeforeAll
    public static void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @AfterEach
    public void closeDriver() {
        closeWebDriver();
    }

    @Tag("positive_tests")
    @Test
    @Story("Regular use case")
    @DisplayName("1.1 Should correctly add Apples to Users sections")
    public void shouldCorrectlyAddApplesToUsersSections() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
        });

        step("Check the sections 'Jonathan', 'Adrian', 'Julie' for Apples and correct counters readings", () -> {
            jonathanAppleList.shouldHave(text("Apple1"));
            jonathanAppleList.$("li", 1).shouldHave(text("Apple5"));
            adrianAppleList.shouldHave(text("Apple2"));
            adrianAppleList.shouldHave(text("Apple4"));
            julieAppleList.shouldHave(text("Apple3"));
            jonathanAppleBadge.shouldHave(text("2"));
            adrianAppleBadge.shouldHave(text("2"));
            julieAppleBadge.shouldHave(text("1"));
            basketSection.shouldNotHave(Condition.cssClass("li"));
        });
    }

    @Tag("positive_tests")
    @Test
    @Story("Сhecking the 'Jonathan' section for the maximum number of apples with an odd id")
    @DisplayName("1.2 Should add all odd Apples to 'Jonathan' section")
    public void shouldAddAllOddApplesToJonathanSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
        });

        step("Check the sections 'Jonathan' for Apples and correct counter reading", () -> {
            jonathanAppleList.shouldHave(text("Apple1"));
            jonathanAppleList.shouldHave(text("Apple3"));
            jonathanAppleList.shouldHave(text("Apple5"));
            jonathanAppleBadge.shouldHave(text("3"));
        });
    }

    @Tag("positive_tests")
    @Test
    @Story("Сhecking the 'Adrian' section for the maximum number of apples with an odd id")
    @DisplayName("1.3 Should add all odd Apples to 'Adrian' section")
    public void shouldAddAllOddApplesToAdrianSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });

        step("Check the sections 'Adrian' for Apples and correct counter reading", () -> {
            adrianAppleList.shouldHave(text("Apple1"));
            adrianAppleList.shouldHave(text("Apple3"));
            adrianAppleList.shouldHave(text("Apple5"));
            adrianAppleBadge.shouldHave(text("3"));
        });
    }

    @Tag("positive_tests")
    @Test
    @Story("Сhecking the 'Julie' section for the maximum number of apples with an odd id")
    @DisplayName("1.4 Should add all odd Apples to 'Julie' section")
    public void shouldAddAllOddApplesToJulieSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });

        step("Check the sections 'Julie' for Apples and correct counter reading", () -> {
            julieAppleList.shouldHave(text("Apple1"));
            julieAppleList.shouldHave(text("Apple3"));
            julieAppleList.shouldHave(text("Apple5"));
            julieAppleBadge.shouldHave(text("3"));
        });
    }

    @Tag("positive_tests")
    @Test
    @Story("Сhecking the 'Jonathan' section for the maximum number of apples with an even id")
    @DisplayName("1.5 Should add all even Apples to 'Jonathan' section")
    public void shouldAddAllEvenApplesToJonathanSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
        });

        step("Check the sections 'Jonathan' for Apples and correct counter reading", () -> {
            jonathanAppleList.shouldHave(text("Apple2"));
            jonathanAppleList.$("li", 1).shouldHave(text("Apple4"));
            jonathanAppleBadge.shouldHave(text("2"));
        });
    }

    @Tag("positive_tests")
    @Test
    @Story("Сhecking the 'Julie' section for the maximum number of apples with an even id")
    @DisplayName("1.6 Should add all even Apples to 'Julie' section")
    public void shouldAddAllEvenApplesToJulieSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
        });

        step("Check the sections 'Julie' for Apples and correct counter reading", () -> {
            julieAppleList.shouldHave(text("Apple2"));
            julieAppleList.$("li", 1).shouldHave(text("Apple4"));
            julieAppleBadge.shouldHave(text("2"));
        });
    }

    @Tag("positive_tests")
    @Test
    @Story("Сhecking the operation of the 'Free Apples' button")
    @DisplayName("1.7 'Basket' frame should have Apple1-Apple5")
    public void basketFrameShouldHaveAllApples() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
        });

        step("Check the sections 'Julie' for Apples and correct counter reading", () -> {
            basketSection.shouldHave(text("Apple1"));
            basketSection.shouldHave(text("Apple2"));
            basketSection.shouldHave(text("Apple3"));
            basketSection.shouldHave(text("Apple4"));
            basketSection.shouldHave(text("Apple5"));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Сhecking the 'Jonathan' section for numbers of apples with an even and odd id")
    @DisplayName("2.1 Should not add odd and even Apples to 'Jonathan' section")
    public void shouldNotAddOddAndEvenApplesToJonathanSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageOddAndEvenIds));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Сhecking the 'Adrian' section for numbers of apples with an even and odd id")
    @DisplayName("2.2 Should not add odd and even Apples to 'Adrian' section")
    public void shouldNotAddOddAndEvenApplesToAdrianSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageOddAndEvenIds));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Сhecking the 'Julie' section for numbers of apples with an even and odd id")
    @DisplayName("2.3 Should not add odd and even Apples to 'Julie' section")
    public void shouldNotAddOddAndEvenApplesToJulieSection() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageOddAndEvenIds));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Checking the operation of the 'Grab apple' button in the 'Jonathan' section with a timeout" +
            " less than required")
    @DisplayName("2.4 Should not add Apples to 'Jonathan' section with a lower timeout")
    public void shouldNotAddApplesToJonathanSectionWithLowerTimeout() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
            sleep(timeout - 1000);
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageTimeout));
            jonathanAppleList.shouldNotHave(text("Apple3"));
            jonathanAppleBadge.shouldHave(text("1"));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Checking the operation of the 'Grab apple' button in the 'Adrian' section with a timeout" +
            " less than required")
    @DisplayName("2.5 Should not add Apples to 'Adrian' section with a lower timeout")
    public void shouldNotAddApplesToAdrianSectionWithLowerTimeout() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
            sleep(timeout - 1000);
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageTimeout));
            adrianAppleList.shouldNotHave(text("Apple3"));
            adrianAppleBadge.shouldHave(text("1"));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Checking the operation of the 'Grab apple' button in the 'Julie' section with a timeout" +
            " less than required")
    @DisplayName("2.6 Should not add Apples to 'Julie' section with a lower timeout")
    public void shouldNotAddApplesToJulieSectionWithLowerTimeout() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
            sleep(timeout - 1000);
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageTimeout));
            julieAppleList.shouldNotHave(text("Apple3"));
            julieAppleBadge.shouldHave(text("1"));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Checking the operation of the 'Grab apple' button in the 'Jonathan' section without a timeout")
    @DisplayName("2.7 Should not add Apples to 'Jonathan' section without a timeout")
    public void shouldNotAddApplesToJonathanSectionWithoutTimeout() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
        });
        step("Click 'Grab apple' button in 'Jonathan' section", () -> {
            jonathanGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageTimeout));
            jonathanAppleList.shouldNotHave(text("Apple3"));
            jonathanAppleBadge.shouldHave(text("1"));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Checking the operation of the 'Grab apple' button in the 'Adrian' section without a timeout")
    @DisplayName("2.8 Should not add Apples to 'Adrian' section without a timeout")
    public void shouldNotAddApplesToAdrianSectionWithoutTimeout() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
        });
        step("Click 'Grab apple' button in 'Adrian' section", () -> {
            adrianGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageTimeout));
            adrianAppleList.shouldNotHave(text("Apple3"));
            adrianAppleBadge.shouldHave(text("1"));
        });
    }

    @Tag("negative_tests")
    @Test
    @Story("Checking the operation of the 'Grab apple' button in the 'Julie' section without a timeout")
    @DisplayName("2.9 Should not add Apples to 'Julie' section without a timeout")
    public void shouldNotAddApplesToJulieSectionWithoutTimeout() {
        link("Alyce Service", baseUrl);

        step("Open service main page", () -> {
            open(baseUrl);
        });
        step("Click 'Free Apples' button", () -> {
            freeApplesButton.click();
            sleep(timeout + 1000);
        });

        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
        });
        step("Click 'Grab apple' button in 'Julie' section", () -> {
            julieGrabButton.click();
        });

        step("Check an error message", () -> {
            errorMessage.shouldBe(visible);
            errorMessage.shouldBe(visible).shouldHave(text(errorMessageTimeout));
            julieAppleList.shouldNotHave(text("Apple3"));
            julieAppleBadge.shouldHave(text("1"));
        });
    }
}
