package stone.paperwork.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pirate_steve on 4/6/2015.
 */
public class Note implements Parcelable {
    private String id;
    private String notebook_id;
    private String title;
    private String content_preview;
    private String content;
    private String created_at;
    private String updated_at;
    private String umask;
    private List<Tag> tags;
    private List<Version> versions;

    public Note(Parcel source) {
        id = source.readString();
        notebook_id = source.readString();
        title = source.readString();
        content_preview = source.readString();
        content = source.readString();
        created_at = source.readString();
        updated_at = source.readString();
        umask = source.readString();

        tags = new ArrayList<Tag>();
        int tagsSize = source.readInt();
        if (tagsSize > 0) {
            source.readTypedList(tags, Tag.CREATOR);
        }

        versions = new ArrayList<Version>();
        int versionsSize = source.readInt();
        if (versionsSize > 0) {
            source.readTypedList(versions, Version.CREATOR);
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotebook_id() {
        return notebook_id;
    }

    public void setNotebook_id(String notebook_id) {
        this.notebook_id = notebook_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent_preview() {
        return content_preview;
    }

    public void setContent_preview(String content_preview) {
        this.content_preview = content_preview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUmask() {
        return umask;
    }

    public void setUmask(String umask) {
        this.umask = umask;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(notebook_id);
        dest.writeString(title);
        dest.writeString(content_preview);
        dest.writeString(content);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(umask);

        if (tags == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(tags.size());
            dest.writeTypedList(tags);
        }

        if (versions == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(versions.size());
            dest.writeTypedList(versions);
        }
    }

    public static final Parcelable.Creator<Note> CREATOR =
            new Parcelable.Creator<Note>() {

                @Override
                public Note createFromParcel(Parcel source) {
                    return new Note(source);
                }

                @Override
                public Note[] newArray(int size) {
                    return new Note[size];
                }
            };
}
