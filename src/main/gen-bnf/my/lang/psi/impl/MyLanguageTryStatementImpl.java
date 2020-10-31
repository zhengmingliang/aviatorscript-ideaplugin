// license description
package my.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static lang.psi.MyLanguageTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import my.lang.psi.*;

public class MyLanguageTryStatementImpl extends ASTWrapperPsiElement implements MyLanguageTryStatement {

  public MyLanguageTryStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public <R> R accept(@NotNull MyLanguageVisitor<R> visitor) {
    return visitor.visitTryStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MyLanguageVisitor) accept((MyLanguageVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MyLanguageCodes> getCodesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MyLanguageCodes.class);
  }

  @Override
  @NotNull
  public MyLanguageExpress getExpress() {
    return findNotNullChildByClass(MyLanguageExpress.class);
  }

}