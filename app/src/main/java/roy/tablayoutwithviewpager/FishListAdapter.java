package roy.tablayoutwithviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FishListAdapter extends BaseAdapter {

    private final Context mContext;
    ArrayList<Fish> myFishList;
    //DisplayImageOptions options;
    //ImageLoader imageLoader = ImageLoader.getInstance();

    //  use universal image loader library

    public FishListAdapter(Context context, ArrayList<Fish> list) {

        mContext = context;
        this.myFishList = list;
        // =============== UIL Initialization =================

       /* options = new DisplayImageOptions.Builder()

                .showImageForEmptyUri(R.drawable.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .displayer(new RoundedBitmapDisplayer(5)).cacheInMemory(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext).diskCacheExtraOptions(480, 480, null).build();
        imageLoader.init(config);
*/
        // =====================================================
    }

    @Override
    public int getCount() {
        // return 100;
        return myFishList.size();

    }

    @Override
    public Object getItem(int position) {
        return myFishList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.listview_item_a_restaurent, parent, false);

            holder = new ViewHolder();

            holder.fish_name = (TextView) convertView
                    .findViewById(R.id.fish_name);

            holder.loaction = (TextView) convertView
                    .findViewById(R.id.textView_fish_loaction);

            holder.fish_pic = (ImageView) convertView
                    .findViewById(R.id.imageView_fish_pic);

            holder.fishPrice = (TextView) convertView
                    .findViewById(R.id.fish_price);
            holder.quantity = (TextView) convertView
                    .findViewById(R.id.fish_quantity);
            holder.quantity_type = (TextView) convertView
                    .findViewById(R.id.fish_quantity_type);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Fish aFish = (Fish) myFishList
                .get(position);
        holder.fish_name.setText(aFish.getFishName());
        holder.loaction.setText(aFish.getLocation());
        holder.fishPrice.setText(aFish.getPrice());
        holder.quantity.setText(aFish.getQuantiity());
        holder.quantity_type.setText(aFish.getQuantity_type());

        // just of

//		imageLoader.displayImage(ApplicationData.myFishList.get(position)
//				.getImage_Url(), holder.fish_pic, options);

        if (holder.fish_pic != null) {

            //

        }
        return convertView;
    }

    class ViewHolder {

        private int catatory_id;
        private TextView fish_name;
        private TextView loaction;
        private TextView fishPrice;
        private TextView quantity;
        private TextView quantity_type;

        private ImageView fish_pic;


    }

}
