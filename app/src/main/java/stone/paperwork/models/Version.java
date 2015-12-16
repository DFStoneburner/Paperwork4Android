package stone.paperwork.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by pirate_steve on 4/6/2015.
 */
public class Version implements Parcelable {
    private String id;
    private String previous_id;
    private String next_id;
    private boolean latest;
    private long timestamp;

    public Version(Parcel source) {
        id = source.readString();
        previous_id = source.readString();
        next_id = source.readString();
        latest = source.readByte() != 0;
        timestamp = source.readLong();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrevious_id() {
        return previous_id;
    }

    public void setPrevious_id(String previous_id) {
        this.previous_id = previous_id;
    }

    public String getNext_id() {
        return next_id;
    }

    public void setNext_id(String next_id) {
        this.next_id = next_id;
    }

    public boolean isLatest() {
        return latest;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(previous_id);
        dest.writeString(next_id);
        dest.writeByte((byte) (latest ? 1 : 0));
        dest.writeLong(timestamp);
    }

    public static final Parcelable.Creator<Version> CREATOR =
            new Parcelable.Creator<Version>() {

                @Override
                public Version createFromParcel(Parcel source) {
                    return new Version(source);
                }

                @Override
                public Version[] newArray(int size) {
                    return new Version[size];
                }
            };
}
