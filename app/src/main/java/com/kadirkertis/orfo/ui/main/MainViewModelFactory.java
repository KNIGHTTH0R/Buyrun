package com.kadirkertis.orfo.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.kadirkertis.data.session.SessionService;
import com.kadirkertis.domain.interactor.checkIn.CheckUserInUseCase;
import com.kadirkertis.domain.interactor.checkIn.CheckUserOutUseCase;
import com.kadirkertis.domain.interactor.qr.ParseQrCodeUseCase;
import com.kadirkertis.domain.repository.PlaceRepository;
import com.kadirkertis.domain.repository.ProductsRepository;
import com.kadirkertis.domain.repository.UserRegisterationRepository;
import com.kadirkertis.domain.services.AuthService;
import com.kadirkertis.domain.services.QRCodeService;
import com.kadirkertis.domain.services.UserTrackingService;

import javax.inject.Inject;

/**
 * Created by Kadir Kertis on 11/26/2017.
 */

public class MainViewModelFactory implements ViewModelProvider.Factory {


    private SharedPreferences sharedPreferences;

    private AuthService authService;

    private QRCodeService qrCodeService;

    private UserTrackingService userTrackingService;

    private CheckUserInUseCase userInUseCase;

    private CheckUserOutUseCase userOutUseCase;

    private ParseQrCodeUseCase parseQrCodeUseCase;

    private SessionService sessionService;

    private UserRegisterationRepository userRegisterationRepository;


    @Inject
    public MainViewModelFactory(SharedPreferences sharedPreferences,
                                AuthService authService,
                                CheckUserInUseCase userInUseCase,
                                CheckUserOutUseCase userOutUseCase,
                                UserTrackingService userTrackingService,
                                QRCodeService qrCodeService,
                                ParseQrCodeUseCase parseQrCodeUseCase,
                                SessionService sessionService,
                                UserRegisterationRepository userRegisterationRepository
    ) {
        this.sharedPreferences = sharedPreferences;
        this.authService = authService;
        this.userInUseCase = userInUseCase;
        this.userOutUseCase = userOutUseCase;
        this.userTrackingService = userTrackingService;
        this.qrCodeService = qrCodeService;
        this.parseQrCodeUseCase = parseQrCodeUseCase;
        this.sessionService = sessionService;
        this.userRegisterationRepository = userRegisterationRepository;

    }

    @NonNull
    @Override
    public MainViewModel create(@NonNull Class modelClass) {
        return new MainViewModel(
                sharedPreferences,
                authService,
                userInUseCase,
                userOutUseCase,
                userTrackingService,
                qrCodeService,
                parseQrCodeUseCase,
                sessionService,
                userRegisterationRepository);
    }
}
