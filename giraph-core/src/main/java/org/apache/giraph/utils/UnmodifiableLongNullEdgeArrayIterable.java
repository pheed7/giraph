/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.giraph.utils;

import org.apache.giraph.graph.Edge;
import org.apache.giraph.graph.EdgeFactory;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;

import com.google.common.collect.UnmodifiableIterator;

import java.util.Iterator;

/**
 * {@link UnmodifiableIterator} over a primitive long array with NullWritable
 * edges.
 */
public class UnmodifiableLongNullEdgeArrayIterable extends
    UnmodifiableIterator<Edge<LongWritable, NullWritable>> implements
    Iterable<Edge<LongWritable, NullWritable>> {
  /** Arrays to iterate over */
  private final long[] longArray;
  /** Offset to array */
  private int offset;

  /**
   * Constructor with array to iterate over.
   * @param longArray Array to iterate over.
   */
  public UnmodifiableLongNullEdgeArrayIterable(final long[] longArray) {
    this.longArray = longArray;
    offset = 0;
  }

  @Override
  public Iterator<Edge<LongWritable, NullWritable>> iterator() {
    return this;
  }

  @Override
  public boolean hasNext() {
    return offset < longArray.length;
  }

  @Override
  public Edge<LongWritable, NullWritable> next() {
    Edge<LongWritable, NullWritable> retval =
        EdgeFactory.create(new LongWritable(longArray[offset]));
    offset++;
    return retval;
  }
}
