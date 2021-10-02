
package ICommon;

public interface ICommonDAO <T>{
      public int save(T t);
        public int edit(T t);
        public int delete(String mEmpCode);
        public T search(String mEmpCode);
        
}
