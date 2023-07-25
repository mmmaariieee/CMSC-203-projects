/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: The Plot class represents a rectangular plot with coordinates,
 * dimensions, and methods to check for overlap and containment, as well as
 * setters and getters for its properties.
 * Due: 07/17/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Mariia Honcharenko
*/

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    /**
     * Checks if the given plot overlaps with this plot.
     * @param plot The plot to check for overlap.
     * @return True if there is overlap, false otherwise.
     */
    public boolean overlaps(Plot plot) {
        // Check if the given plot is completely outside of this plot
        if (plot.x >= (x + width) || (plot.x + plot.width) <= x || plot.y >= (y + depth) || (plot.y + plot.depth) <= y) {
            return false;
        }
        
        // Check if the given plot shares any common area with this plot
        return true;
    }

    /**
     * Checks if this plot encompasses the given plot.
     * @param plot The plot to check for containment.
     * @return True if this plot encompasses the given plot, false otherwise.
     */
    public boolean encompasses(Plot plot) {
        return (x <= plot.x) && (x + width >= plot.x + plot.width)
                && (y <= plot.y) && (y + depth >= plot.y + plot.depth);
    }

    /**
     * Sets the x-coordinate of the plot.
     * @param x The new x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the plot.
     * @param y The new y-coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the width of the plot.
     * @param width The new width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the depth of the plot.
     * @param depth The new depth.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Returns the x-coordinate of the plot.
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the plot.
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the width of the plot.
     * @return The width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the depth of the plot.
     * @return The depth.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Returns a string representation of the plot in the format "x,y,width,depth".
     * @return The string representation of the plot.
     */
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
