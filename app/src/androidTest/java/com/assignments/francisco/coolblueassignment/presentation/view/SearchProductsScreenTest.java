package com.assignments.francisco.coolblueassignment.presentation.view;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.assignments.francisco.coolblueassignment.R;
import com.assignments.francisco.coolblueassignment.presentation.view.activity.MainActivity;
import com.assignments.francisco.coolblueassignment.utils.Copy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Search products screen UI test class.
 *
 * @author Francisco Visintini
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
//TODO This UI tests don't have the best approach. Correct way will be to intercept calls and return mocked product objects,
// as to validate correct and well displayed info inside each item of the recycler view. Also we would need to mock server and
// empty products responses.
public class SearchProductsScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void searchProducts_shouldShowDefaultCategoryProducts() {
        onView(withId(R.id.showing_items_label)).check(matches(withText(Copy.DEFAULT_SHOWING_ITEMS_LABEL)));
        onView(withId(R.id.products_recycler)).check(matches(isDisplayed()));
    }

    @Test
    public void searchProducts_withKeywords_shouldShowProducts() {
        //ACTIONS
        onView(withId(R.id.search_box)).perform(typeText(Copy.MOCKED_SEARCH_TEXT), closeSoftKeyboard());
        onView(withId(R.id.search_button)).perform(click());

        //CHECKS
        onView(withId(R.id.showing_items_label)).check(matches(withText(Copy.getShowingItemsLabel(100, Copy.MOCKED_SEARCH_TEXT))));
        onView(withId(R.id.products_recycler)).check(matches(isDisplayed()));
    }

    @Test
    public void searchProducts_withKeywordsAndFilters_shouldShowProductsAndHideFilters() {
        //ACTIONS
        onView(withId(R.id.search_box)).perform(typeText(Copy.MOCKED_SEARCH_TEXT), closeSoftKeyboard());
        onView(withId(R.id.toolbar_filter)).perform(click());
        onView(withId(R.id.min_price_filter)).perform(typeText(Copy.MOCKED_MIN_PRICE_FILTER), closeSoftKeyboard());
        onView(withId(R.id.max_price_filter)).perform(typeText(Copy.MOCKED_MAX_PRICE_FILTER), closeSoftKeyboard());
        onView(withId(R.id.search_button)).perform(click());

        //CHECKS
        onView(withId(R.id.showing_items_label)).check(matches(withText(Copy.getShowingItemsLabel(100, Copy.MOCKED_SEARCH_TEXT))));
        onView(withId(R.id.products_recycler)).check(matches(isDisplayed()));
    }
}
