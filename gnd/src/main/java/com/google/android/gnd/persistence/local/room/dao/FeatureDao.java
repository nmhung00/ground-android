/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gnd.persistence.local.room.dao;

import androidx.room.Dao;
import androidx.room.Query;
import com.google.android.gnd.persistence.local.room.entity.FeatureEntity;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import java.util.List;

/** Provides low-level read/write operations of {@link FeatureEntity} to/from the local db. */
@Dao
public interface FeatureDao extends BaseDao<FeatureEntity> {
  @Query("SELECT * FROM feature WHERE project_id = :projectId AND state = 1")
  Flowable<List<FeatureEntity>> findByProjectIdStream(String projectId);

  @Query("SELECT * FROM feature WHERE id = :id")
  Maybe<FeatureEntity> findById(String id);
}
