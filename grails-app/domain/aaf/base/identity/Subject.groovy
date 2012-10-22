package aaf.base.identity

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString(includeNames=true, includeFields=true, excludes="sharedToken")
@EqualsAndHashCode
class Subject {
  static auditable = true

  String principal
  String cn
  String email
  String sharedToken

  boolean enabled

  static belongsTo = Role

  static hasMany = [ 
    sessionRecords: SessionRecord, 
    roles: Role, 
    permissions: Permission 
  ]

  static constraints = {
    principal(nullable: false, blank: false, unique:true)
    cn nullable:false, blank:false
    email email:true
    sharedToken nullable:false, blank:false
  }
}
