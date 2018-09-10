package com.kadirkertis.orfo.ui.Router;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.BuildConfig;
import com.kadirkertis.domain.utils.Constants;
import com.kadirkertis.orfo.R;
import com.kadirkertis.orfo.ui.cart.CartActivity;
import com.kadirkertis.orfo.ui.chat.ChatActivity;

import java.util.Arrays;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Kadir Kertis on 11/9/2017.
 */

public class RouterImpl implements Router {


    @Override
    public void showCartScreen(AppCompatActivity source) {

        Intent intent = new Intent(source, CartActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            source.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(source, null)
                    .toBundle());
        } else {
            source.startActivity(intent);
        }

    }

    @Override
    public void showProductsScreen(AppCompatActivity source) {

    }

    @Override
    public void showMainScreen(AppCompatActivity source) {

    }

    @Override
    public void showChatScreen(AppCompatActivity source, String storeId) {
        Intent intentCh = new Intent(source, ChatActivity.class);
        intentCh.putExtra(Constants.EXTRA_PLACE_ID, storeId);
        intentCh.putExtra(Constants.EXTRA_USER_ID, source.getSharedPreferences(Constants.PREFS_CHECKED_IN_PLACE, MODE_PRIVATE)
                .getString(Constants.PREFS_USER_ID, null));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            source.startActivity(intentCh, ActivityOptionsCompat.makeSceneTransitionAnimation(source, null)
                    .toBundle());
        } else {
            source.startActivity(intentCh);
        }

    }

    @Override
    public void showPreferencesScreen(AppCompatActivity source) {

    }

    @Override
    public void showAuthScreen(@NonNull AppCompatActivity source) {
        //TODO Add privacy policy setTosAndPrivacyPolicyUrls
        source.startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.GoogleBuilder().build(),
                                new AuthUI.IdpConfig.EmailBuilder().build()
                        ))
                        .setTheme(R.style.My_FirebaseUI)
                        .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                        .setLogo(R.drawable.orfolognobg)
                        .build(),
                Constants.RC_SIGN_IN);
    }


}
