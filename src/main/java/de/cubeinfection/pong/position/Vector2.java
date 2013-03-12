package de.cubeinfection.pong.position;

public class Vector2
{
    private float x;
    private float y;

    /**
     * Creates a new Vector2 with a pair of int
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vector2(int x, int y)
    {
        this((float)x, (float)y);
    }

    /**
     * Creates a new Vector2 with a pair of double
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    public float getX()
    {
        return this.x;
    }

    public int getRoundedX()
    {
        return Math.round(this.x);
    }

    public float getY()
    {
        return this.y;
    }

    public int getRoundedY()
    {
        return Math.round(this.y);
    }

    /**
     * Checks whether an other Vector2 ist orthogonal to this one
     *
     * @param other the other Vector2
     * @return whether the other Vector2 is orthogonal to this one
     */
    public boolean isOrthogonal(Vector2 other)
    {
        return (this.dot(other) == 0.0);
    }

    /**
     * Checks whether an other Vector2 ist parallel to this one
     *
     * @param other the other Vector2
     * @return whether the other Vector2 is parallel to this one
     */
    public boolean isParallel(Vector2 other)
    {
        return (this.x / other.x == this.y / other.y);
    }

    /**
     * Returns the scalar product of this Vektor and the other
     *
     * @param other the second vector to multiply with
     * @return the scalar product
     */
    public double dot(Vector2 other)
    {
        return (this.x * other.x + this.y * other.y);
    }

    /**
     * Returns the sum of an other Vector2 and this one as a Vector2
     *
     * @param other the Vector2 to add
     */
    public void add(Vector2 other)
    {
        this.x += other.x;
        this.y += other.y;
    }

    /**
     * Returns the difference between an other Vector2 and this one as a Vector2
     *
     * @param other the Vector2 to substract
     */
    public void substract(Vector2 other)
    {
        this.x -= other.x;
        this.y -= other.y;
    }

    /**
     * Returns this vector multiplied with the factor n
     *
     * @param n a number to multiply all coordinates by
     * @return the new Vector
     */
    public Vector2 multiply(int n)
    {
        return this.multiply((float)n);
    }

    /**
     * Returns this vector multiplied with the factor n
     *
     * @param n a number to multiply all coordinates by
     * @return the new Vector
     */
    public Vector2 multiply(float n)
    {
        return new Vector2(this.x * n, this.y * n);
    }

    /**
     * Returns this vector divided by the quotient n
     *
     * @param n a number to divide all coordinates by
     * @return the new Vector
     */
    public Vector2 divide(int n)
    {
        return this.divide((float)n);
    }

    /**
     * Returns this vector divided by the quotient n
     *
     * @param n a number to divide all coordinates by
     * @return the new Vector
     */
    public Vector2 divide(float n)
    {
        return new Vector2(this.x / n, this.y / n);
    }

    /**
     * Returns the squared length
     *
     * @return the length²
     */
    public double squaredLength()
    {
        return (Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**
     * Returns the length
     *
     * @return the length
     */
    public double length()
    {
        return Math.sqrt(this.squaredLength());
    }

    /**
     * Returns the distance between an other Vector2 and this one as a Vector2
     *
     * @param other the Vector2 to substract from
     * @return the new Vector
     */
    public Vector2 distanceVector(Vector2 other)
    {
        return new Vector2(other.x - this.x, other.y - this.y);
    }

    /**
     * Returns the squared distance between an other Vector2 and this one
     *
     * @param other the Vector2 to get the distance from
     * @return the squared distance
     */
    public double squaredDistance(Vector2 other)
    {
        return this.distanceVector(other).squaredLength();
    }

    /**
     * Returns the distance between an other Vector2 and this one
     *
     * @param other the Vector2 to get the distance from
     * @return the distance
     */
    public double distance(Vector2 other)
    {
        return this.distanceVector(other).length();
    }

    /**
     * Returns the angle of the other Vector to this one
     *
     * @param other  the other Vector2 to calculate the angle to
     * @return the angle between the vectors
     */
    public double crossAngle(Vector2 other)
    {
        return Math.acos(this.dot(other) / (this.length() * other.length()));
    }

    /**
     * Returns the normalized Vector
     *
     * @return the normalized Vector2
     */
    public Vector2 normalize()
    {
        return this.divide((float)this.length());
    }

    /**
     * Returns a Vector2 to the midpoint between this Vector and the other
     *
     * @param other the other Vector2
     * @return the midpoint
     */
    public Vector2 midpoint(Vector2 other)
    {
        return new Vector2(other.x / 2, other.y / 2);
    }

    /**
     * Returns whether the Object o equals this Vector
     *
     * @param o an Object
     * @return whether o is the same Vector as this one
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (!(o instanceof Vector2))
        {
            return false;
        }

        Vector2 other = (Vector2)o;

        return (this.x == other.x && this.y == other.y);
    }

    /**
     * Returns a HashCode representing this Vector
     *
     * @return the HashCode of this Vector2
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 53 * hash + (int)(Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 53 * hash + (int)(Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    /**
     * Returns a String representing this Vector
     *
     * @return the String representing this Vector2
     */
    @Override
    public String toString()
    {
        return "(" + this.x + "|" + this.y + ")";
    }
}
