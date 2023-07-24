package COM.TQC.GDD01;

public class Deal {
    private String goods,distance,time,price;
    private int mThumbnail;

    public String getName()
    {
        return goods;
    }

    public void setGoods(String goods)
    {
        this.goods = goods;
    }

    public void setDistance(String distance)
    {
        this.distance = distance;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getPrice()
    {
        return price;
    }

    public String getGoods()
    {
        return goods;
    }

    public String getDistance()
    {
        return distance;
    }

    public String getTime()
    {
        return time;
    }

    public int getThumbnail()
    {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail)
    {
        this.mThumbnail = thumbnail;
    }
}
