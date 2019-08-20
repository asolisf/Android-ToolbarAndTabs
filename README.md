# Toolbar

Toolbar es la versión más actual que proporciona soporte Material Design a versiones antiguas de android.

Instalar librería

```gradle
implementation 'com.android.support:design:28.0.0'
```

Crear layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.Toolbar
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="@color/colorPrimary"
    android:elevation="4dp"
    android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
    app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
```

Reutilizarla en las vistas

```xml
<include
    android:id="@+id/toolbar"
    layout="@layout/toolbar" />
```

Asignarla como la **ActionBar**

```java
private Toolbar customToolbar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.customToolbar = findViewById(R.id.toolbar);
    this.customToolbar.setTitle(R.string.app_name);
    setSupportActionBar(this.customToolbar);
}
```
# TabLayout

Implementamos el **TabLayout**

```xml
<android.support.design.widget.TabLayout
    android:id="@+id/tabLayout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorPrimary"
    android:elevation="4dp"
    android:minHeight="?attr/actionBarSize"
    android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar" />
```

ViewPager para el swipe

```xml
<android.support.v4.view.ViewPager
    android:id="@+id/viewPager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"></android.support.v4.view.ViewPager>
```

Agregar tabs y gravity en el code behind

```java
this.tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
this.tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
this.tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
this.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
```

**PagerAdapter** implementación requerida para el **ViewPager**

```java
public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int tabs) {
        super(fm);
        this.numberOfTabs = tabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.numberOfTabs;
    }
}
```

Asignar el **PagerAdapter** al **ViewPager**.

```java
PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                                                tabLayout.getTabCount());

this.viewPager.setAdapter(pagerAdapter);
this.viewPager.addOnPageChangeListener(
        new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout)
);
```

**OnTabSelectedListener**

```java
this.tabLayout.addOnTabSelectedListener(this);
```

```java
@Override
public void onTabSelected(TabLayout.Tab tab) {
    int position = tab.getPosition();
    this.viewPager.setCurrentItem(position);
}
```


