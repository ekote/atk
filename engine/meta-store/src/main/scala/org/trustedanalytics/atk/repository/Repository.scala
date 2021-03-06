/**
 *  Copyright (c) 2015 Intel Corporation 
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.trustedanalytics.atk.repository

import org.trustedanalytics.atk.domain.HasId

import scala.util.Try

/**
 * Repository interface for read/write operations (CRUD) for a single table.
 *
 * @tparam CreateEntity type of entity for initial creation
 * @tparam Entity type of entity
 */
trait Repository[Session, CreateEntity, Entity <: HasId] extends ReadRepository[Session, Entity] {

  /**
   * Insert a row
   * @param entity values to insert
   * @return the newly created Entity
   */
  def insert(entity: CreateEntity)(implicit session: Session): Try[Entity]

  /**
   * Update a row
   * @return the updated Entity
   */
  def update(entity: Entity)(implicit session: Session): Try[Entity]

  /**
   * Row to delete
   */
  def delete(id: Long)(implicit session: Session): Try[Unit]
}
