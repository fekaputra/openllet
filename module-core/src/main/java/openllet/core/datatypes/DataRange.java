package openllet.core.datatypes;

import java.util.Iterator;

/**
 * <p>
 * Title: Data Range
 * </p>
 * <p>
 * Description: Data range interface openllet.shared.hash by all _data ranges (restricted datatypes, enumerations, etc.)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: Clark & Parsia, LLC. <http://www.clarkparsia.com>
 * </p>
 *
 * @author Mike Smith
 * @param <T> type of literals
 */
public interface DataRange<T>
{

	/**
	 * Check if a _data range contains a particular value
	 *
	 * @param value the value to check
	 * @return <code>true</code> if the _data range contains <code>value</code>, <code>false</code> else
	 */
	public boolean contains(Object value);

	/**
	 * Check that a _data range contains a minimum number of elements
	 *
	 * @param n the number of elements
	 * @return <code>true</code> if the _data range contains <code>n</code> or more elements, <code>false</code> otherwise
	 */
	public boolean containsAtLeast(int n);

	/**
	 * Convenience method equivalent to <code>!containsAtLeast(0)</code>
	 *
	 * @return <code>true</code> if the _data range contains no elements, <code>false</code> otherwise
	 */
	public boolean isEmpty();

	/**
	 * Query if values in the _data range can be enumerated.
	 *
	 * @return <code>true</code> if the _data range is enumerable, <code>false</code> otherwise
	 */
	public boolean isEnumerable();

	/**
	 * Query if there are a finite number of values in the _data range.
	 *
	 * @return <code>true</code> if the _data range is finite, <code>false</code> otherwise
	 */
	public boolean isFinite();

	/**
	 * Return the size of the _data range. <i>Necessary to support LiteralValueBranch constructor</i>
	 *
	 * @return the size of the _data range
	 * @throws IllegalStateException if {@link #isFinite()} returns <code>false</code>
	 * @deprecated Use {@link #containsAtLeast(int)}
	 */
	@Deprecated
	default public int size()
	{
		throw new IllegalStateException();
	}

	/**
	 * Return a value from an enumerable _data range. <i>Necessary to support LiteralValueBranch shiftTryNext</i>
	 *
	 * @param i the _index of the value in the _data range
	 * @return the value
	 * @throws IllegalStateException if {@link #isEnumerable()} returns <code>false</code>
	 * @deprecated Use {@link #valueIterator()}
	 */
	@Deprecated
	default public T getValue(final int i)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Get a (possibly infinite) iterator over values in the _data range.
	 *
	 * @return an {@link Iterator}
	 * @throws IllegalStateException if {@link #isEnumerable()} returns <code>false</code>
	 */
	public Iterator<T> valueIterator();
}
