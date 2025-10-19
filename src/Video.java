package tubeVideosManager;

import java.util.ArrayList;

public class Video implements Comparable<Video> {
	private String title, url;
	private int durationInMinutes;
	private Genre videoGenre;
	private ArrayList<String> comments;

	/**
	 * Initializes a video object. If any parameter is null or if a string parameter
	 * is a blank (according to String class isBlank() method), the method will
	 * throw an IllegalArgumentException (with any message) and perform no
	 * processing. Also the same exception will be thrown if the duration is zero or
	 * negative.
	 * 
	 * @param title
	 * @param url
	 * @param durationInMinutes
	 * @param videoGenre
	 */
	public Video(String title, String url, int durationInMinutes, Genre videoGenre) {
		
		if(title == null || title.isBlank() || url == null || url.isBlank() || //checks if parameters are good
				videoGenre == null || durationInMinutes <= 0) {
			
			// if invalid throws IllegalArgument Exception
			throw new IllegalArgumentException("This is not a correct input!"); 
		}
		
		this.title = title; 
		this.url = url;
		this.durationInMinutes = durationInMinutes;
		this.videoGenre = videoGenre;
		
		this.comments = new ArrayList<String>(); //prepares the comment list
;	}

	/**
	 * Initializes the Video object so changes to the parameter do not affect the
	 * current object. Your implementation must be efficient (avoid any unnecessary
	 * copies).
	 * 
	 * @param video
	 */
	public Video(Video video) {
		
		//Creates copy of another video
		this.title = video.getTitle();
		this.url = video.getUrl();
		this.durationInMinutes = video.getDurationInMinutes();
		this.videoGenre = video.getGenre();
		this.comments = new ArrayList<String>(video.getComments());
	}

	/**
	 * Get method for title
	 * 
	 * @return title string
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Get method for url
	 * 
	 * @return url string
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Get method for duration
	 * 
	 * @return duration
	 */
	public int getDurationInMinutes() {
		return this.durationInMinutes;
	}

	/**
	 * Get method for video genre
	 * 
	 * @return string with genre
	 */
	public Genre getGenre() {
		return this.videoGenre;
	}

	/**
	 * toString for class
	 * 
	 * @return string with object info
	 */
	public String toString() {
		String answer = "Title: " + "\"" + title + "\"\n";

		answer += "Url: " + url + "\n";
		answer += "Duration (minutes): " + durationInMinutes + "\n";
		answer += "Genre: " + videoGenre + "\n";

		return answer;
	}

	/**
	 * Adds specified comments to the video. If the parameter is null or is a blank
	 * string (according to String class isBlank() method) the method will throw an
	 * IllegalArgumentException (with any message) and perform no processing.
	 * 
	 * @param comments
	 * @return true if comments added; false otherwise
	 */
	public boolean addComments(String comments) {
		if(comments == null || comments.isBlank()) { //checks the comments parameter to make sure valid
			throw new IllegalArgumentException("Comments is null or blank!");
		}
		this.comments.add(comments); //add the good comments to my video's own comments
		return true;
	}

	/**
	 * Returns copy so changes to the copy does not affect the original. Your
	 * implementation must be efficient (avoid any unnecessary copies).
	 * 
	 * @return ArrayList of strings
	 */
	public ArrayList<String> getComments() { //returns new ArrayList that is copy of my comments
		 return new ArrayList<String>(this.comments);
	}

	/**
	 * Videos will be compared using title. If we were to sort an ArrayList of
	 * Videos, they will appear in lexicographical (alphabetical) order (e.g, "A",
	 * "B", "C").
	 * 
	 * @return negative, 0, or positive value
	 */
	public int compareTo(Video video) { // compares the two titles and gives back number needed
		return this.title.compareTo(video.getTitle());
	}

	/**
	 * Two Video objects are considered equal if they have the same title. Implement
	 * the method using the instanceof operator rather than using getClass().
	 * 
	 * @return true if objects are considered equal; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Video) || obj == null) {
			return false;
		}
		
		Video otherVideo = (Video) obj; // need to unmask the object to use its specific skills
		return this.title.equals(otherVideo.getTitle()); //compares title to the other video's title
		
	}
}
