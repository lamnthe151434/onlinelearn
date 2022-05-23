
package model;

import java.sql.Blob;

/**
 *
 * @author ADMIN
 */
public class Topic {
    private int topicId;
    private String topicName;
    private Blob image;
    private String description;

    public Topic() {
    }

    public Topic(int topicId, String topicName, Blob image, String description) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.image = image;
        this.description = description;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
}
