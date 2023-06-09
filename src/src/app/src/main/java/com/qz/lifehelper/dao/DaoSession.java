package com.qz.lifehelper.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig imageDaoConfig;
    private final DaoConfig p2PDaoConfig;
    private final DaoConfig pOIDaoConfig;

    private final UserDao userDao;
    private final ImageDao imageDao;
    private final P2PDao p2PDao;
    private final POIDao pOIDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        imageDaoConfig = daoConfigMap.get(ImageDao.class).clone();
        imageDaoConfig.initIdentityScope(type);

        p2PDaoConfig = daoConfigMap.get(P2PDao.class).clone();
        p2PDaoConfig.initIdentityScope(type);

        pOIDaoConfig = daoConfigMap.get(POIDao.class).clone();
        pOIDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        imageDao = new ImageDao(imageDaoConfig, this);
        p2PDao = new P2PDao(p2PDaoConfig, this);
        pOIDao = new POIDao(pOIDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Image.class, imageDao);
        registerDao(P2P.class, p2PDao);
        registerDao(POI.class, pOIDao);
    }

    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        imageDaoConfig.getIdentityScope().clear();
        p2PDaoConfig.getIdentityScope().clear();
        pOIDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ImageDao getImageDao() {
        return imageDao;
    }

    public P2PDao getP2PDao() {
        return p2PDao;
    }

    public POIDao getPOIDao() {
        return pOIDao;
    }

}
