package com.xiekeer.omgandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.xiekeer.entity.Product;
import com.xiekeer.entity.ProductAdapter;
import com.xiekeer.entity.ShoppingCartHelper;

import java.util.List;

/**
 * Created by caozheng on 7/2/15.
 */
public class CatalogActivity extends Activity {

    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog);

        mProductList = ShoppingCartHelper.getCatalog(getResources());

        ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);

        listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);

        viewShoppingCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewShoppingCartIntent = new Intent (getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });


    }


}
