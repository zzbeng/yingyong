package com.xiekeer.entity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiekeer.omgandroid.R;

import java.util.List;

/**
 * Created by zheng_cao on 7/2/2015.
 */
public class ProductAdapter extends BaseAdapter {

    private List<Product> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;

    public ProductAdapter (List<Product> list, LayoutInflater inflater, boolean showCheckbox) {
        mProductList = list;
        mInflater = inflater;
        mShowCheckbox =showCheckbox;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item, null);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView.findViewById(R.id.ImageViewItem);
            item.productTitle = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);
            convertView.setTag(item);

        } else {
            item = (ViewItem) convertView.getTag();
        }

        Product currentProduct = mProductList.get(position);

        item.productTitle.setText(currentProduct.title);
        item.productImageView.setImageDrawable(currentProduct.productImage);

        //show the products checked
        if (!mShowCheckbox) {
            item.productCheckBox.setVisibility(View.GONE);
        }else {
            if(currentProduct.selected) {item.productCheckBox.setChecked(true);}
            else {item.productCheckBox.setChecked(false);}
        }
        return convertView;
    }

    private class ViewItem {
        ImageView productImageView;
        TextView productTitle;
        CheckBox productCheckBox;
    }
}
