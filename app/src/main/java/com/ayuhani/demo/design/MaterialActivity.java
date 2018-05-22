package com.ayuhani.demo.design;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ayuhani.demo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaterialActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private Fruit[] fruits = {
            new Fruit("Apple", "https://timgsa.baidu" +
                    ".com/timg?image&quality=80&size=b9999_10000&sec=1526978912942&di=0e820aa1d1592bc295c522b44ef749db" +
                    "&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01dcd85848d383a801219c776036ef" +
                    ".jpg%401280w_1l_2o_100sh.jpg"),
            new Fruit("Banana", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4215206992," +
                    "3177658596&fm=27&gp=0.jpg"),
            new Fruit("Orange", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2361722178," +
                    "1678035642&fm=27&gp=0.jpg"),
            new Fruit("Watermelon", "https://timgsa.baidu" +
                    ".com/timg?image&quality=80&size=b9999_10000&sec=1526979120249&di=249300c9a31bc212dbf953bc29c2b532" +
                    "&imgtype=0&src=http%3A%2F%2Fs7.sinaimg.cn%2Fmw690%2F006SmQiozy7d4wQoe9w86%26690"),
            new Fruit("Pear", "https://timgsa.baidu" +
                    ".com/timg?image&quality=80&size=b9999_10000&sec=1527573904&di=9649552f165b24c92d799cf8210d093c" +
                    "&imgtype=jpg&er=1&src=http%3A%2F%2Fimg1.ph.126.net%2FjzfYSwdRTT25LjNdtWz-yA%3D%3D" +
                    "%2F6631525162538273293.jpg"),
            new Fruit("Grape", "https://timgsa.baidu" +
                    ".com/timg?image&quality=80&size=b9999_10000&sec=1526979219413&di=97ad2672b5e522e7ff1bb7302a8faa9b" +
                    "&imgtype=0&src=http%3A%2F%2Fimg.jkys5.com%2Fallimg%2F150117%2F7_150117133116_1.jpg"),
            new Fruit("Pineapple", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=434976285," +
                    "2948419532&fm=27&gp=0.jpg"),
            new Fruit("Strawberry", "https://timgsa.baidu" +
                    ".com/timg?image&quality=80&size=b9999_10000&sec=1526979289348&di=a5773d5d07476a3722f39815829dc986" +
                    "&imgtype=0&src=http%3A%2F%2Fimg0.pclady.com" +
                    ".cn%2Fpclady%2F1801%2F30%2F1798004_40212401_1490263398769.jpg"),
            new Fruit("cherry", "https://timgsa.baidu" +
                    ".com/timg?image&quality=80&size=b9999_10000&sec=1526979419119&di=835991291a7631dea195b2f6973a3d80" +
                    "&imgtype=0&src=http%3A%2F%2Fs1.sinaimg.cn%2Fbmiddle%2F4ce5175fgd318b21a2a80%26690"),
            new Fruit("Mango", "https://timgsa.baidu" +
                    ".com/timg?image&quality=80&size=b9999_10000&sec=1526979864908&di=9e17910d3c5a4981d5131e48d1446fe8" +
                    "&imgtype=0&src=http%3A%2F%2Fwww.cyone.com" +
                    ".cn%2Fzhishi%2FUploadFiles_1234%2F201703%2F2017033119184821.jpg")
    };
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter adapter;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.menu);
        }

        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Data deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MaterialActivity.this, "Data restored", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setColorSchemeColors(R.color.colorPrimary);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFurits();
            }
        });
    }

    private void refreshFurits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        refreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initFruits() {
        fruitList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }
}
