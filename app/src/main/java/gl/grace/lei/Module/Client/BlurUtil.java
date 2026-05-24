package gl.grace.lei.Module.Client;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
/*
By:SuMuCheng
 */
public final class BlurUtil {

  private BlurUtil() {
  }

  public static BitmapDrawable Blur(Context context,View view1,int radius) {
      final View view = (View)view1;
      final RenderScript renderScript = RenderScript.create(context);
      view.buildDrawingCache();
      final Bitmap origin = view.getDrawingCache();
      Allocation input = Allocation.createFromBitmap(renderScript, origin);
      Allocation output = Allocation.createTyped(renderScript, input.getType());
      ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
      blur.setRadius(radius);
      blur.setInput(input);
      blur.forEach(output);
      output.copyTo(origin);
      Bitmap bitmap = Bitmap.createBitmap(origin);
      return new BitmapDrawable(context.getResources(), bitmap);
  }

  public static BitmapDrawable Blur() {
    return Blur(null,null,0);
  }

}
