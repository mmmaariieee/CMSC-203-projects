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

    public boolean overlaps(Plot plot) {
    	// Check if the given plot is completely outside of this plot
        if (plot.x >= (x + width) || (plot.x + plot.width) <= x || plot.y >= (y + depth) || (plot.y + plot.depth) <= y) {
            return false;
        }
        
        // Check if the given plot shares any common area with this plot
        return true;
    }

    public boolean encompasses(Plot plot) {
        return (x <= plot.x) && (x + width >= plot.x + plot.width)
                && (y <= plot.y) && (y + depth >= plot.y + plot.depth);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
