import JoinSelType from '@/views/member/JoinSelType.vue'
import JoinMaster from '@/views/member/JoinMaster.vue'
import JoinMember from '@/views/member/JoinMember.vue'

const mtrPath = '/member/'
export default [
  {
    /** 회원가입(마스터,그룹) 선택 화면 */
    path: mtrPath + 'joinOpt',
    name: 'joinOpt',
    component: JoinSelType
  },
  {
    /** 마스터 그룹 등록 및 선택 화면 */
    path: mtrPath + 'joinMaster/:joinType',
    name: 'joinMaster',
    component: JoinMaster,
    props: true
  },
  {
    /** 일반회원 등록 화면 */
    path: mtrPath + 'joinMember/:joinType/:grpMemberSeq',
    name: 'joinMember',
    component: JoinMember,
    props: true
  }
]
