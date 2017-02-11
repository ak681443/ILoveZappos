package com.ak681443.ilovezappos.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;

import com.ak681443.ilovezappos.R;

/**
 * Created by arvind on 2/9/17.
 */

public class SearchBar extends AutoCompleteTextView {

    int horizontalMargin;

    public SearchBar(Context context) {
        super(context);
    }

    public SearchBar(Context context, AttributeSet attribute_set) {
        super(context, attribute_set);
    }

    public SearchBar(Context context, AttributeSet attribute_set, int def_style_attribute) {
        super(context, attribute_set, def_style_attribute);
    }

    private boolean isKeyBoardShown = false;

    private void showKeyBoard() {
        InputMethodManager immService = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        immService.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                        InputMethodManager.HIDE_IMPLICIT_ONLY);
        isKeyBoardShown = true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
        final int horizontalMargin = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
        if(focused){
            params.removeRule(RelativeLayout.CENTER_VERTICAL);
            params.setMargins(0, 0, 0, 0);
            setLayoutParams(params);
            showKeyBoard();
        } else {
            params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
            params.setMargins(horizontalMargin, 0, horizontalMargin, 0);
            setLayoutParams(params);
            hideKeyBoard();
        }
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    private void hideKeyBoard() {
        InputMethodManager immService = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (immService != null) {
            immService.hideSoftInputFromWindow(getWindowToken(), 0);

        }
        isKeyBoardShown = false;
    }


    //Workaround to handle back button properly
    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if (state != null) {
                    state.startTracking(event, this);
                }
                return true;
            } else if (event.getAction() == KeyEvent.ACTION_UP) {
                KeyEvent.DispatcherState state = getKeyDispatcherState();
                if (state != null) {
                    state.handleUpEvent(event);
                }
                if (event.isTracking() && !event.isCanceled()) {
                    if(isKeyBoardShown){
                        hideKeyBoard();
                    } else {
                        clearFocus();
                        setText("");
                    }
                    return true;
                }
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
