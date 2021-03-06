package com.kadirkertis.domain.interactor.place.repository;

import com.kadirkertis.domain.interactor.place.model.Place;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Kadir Kertis on 11/9/2017.
 */

public interface FavoriteRepository {

    Completable addPlaceToFavorites(Place place);
    Completable deleteFromFavorites(Place place);
    Single<Boolean> isPlaceInFav(Place place);
}
