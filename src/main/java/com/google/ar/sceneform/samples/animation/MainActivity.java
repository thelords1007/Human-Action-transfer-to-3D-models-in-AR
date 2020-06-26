
package com.google.ar.sceneform.samples.animation;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.SkeletonNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

/** Demonstrates playing animated FBX models. */
public class MainActivity extends AppCompatActivity {

  private static final String TAG = "AnimationSample";
  private static final int ANDY_RENDERABLE = 1;
  private static final int HAND_RENDERABLE = 2;
  private static final String HAT_BONE_NAME = "hat_point";
  private ArFragment arFragment;
  // Model loader class to avoid leaking the activity context.
  private ModelLoader modelLoader1;
  //private ModelLoader modelLoader2;
  private ModelRenderable andyRenderable;
  //private ModelRenderable handRenderable;
  private AnchorNode anchorNode;
  private SkeletonNode andy;
  // Controls animation playback.
  private ModelAnimator animator;
  private ModelAnimator animator1;
  private ModelAnimator animator2;
  // Index of the current animation playing.
  private int nextAnimation;
  //private int nextAnimation1;
  // The UI to play next animation.
  private FloatingActionButton animationButton;
  // The UI to toggle wearing the hat.
  private FloatingActionButton handButton;
  private FloatingActionButton runButton;
  private FloatingActionButton walkButton;
  private FloatingActionButton throwButton;
  //private Node hatNode;
  //private ModelRenderable hatRenderable;

  @Override
  @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);

    modelLoader1 = new ModelLoader(this);
    modelLoader1.loadModel(ANDY_RENDERABLE, R.raw.run);
    //modelLoader2 = new ModelLoader(this);
    //modelLoader2.loadModel(HAND_RENDERABLE, R.raw.hand);

    //modelLoader.loadModel(HAT_RENDERABLE, R.raw.baseball_cap);

    // When a plane is tapped, the model is placed on an Anchor node anchored to the plane.
    arFragment.setOnTapArPlaneListener(this::onPlaneTap);

    // Add a frame update listener to the scene to control the state of the buttons.
    arFragment.getArSceneView().getScene().addOnUpdateListener(this::onFrameUpdate);

    // Once the model is placed on a plane, this button plays the animations.
    animationButton = findViewById(R.id.animate);
    //modelLoader.loadModel(ANDY_RENDERABLE, R.raw.walk);
    animationButton.setEnabled(false);
    animationButton.setOnClickListener(this::onPlayAnimation);

    // Place or remove a hat on Andy's head showing how to use Skeleton Nodes.
    handButton = findViewById(R.id.hand);
    handButton.setEnabled(false);
    handButton.setOnClickListener(this::onPlayAnimation1);

    runButton = findViewById(R.id.run);
    runButton.setEnabled(false);
    runButton.setOnClickListener(this::onPlayAnimation2);

    walkButton = findViewById(R.id.walk);
    walkButton.setEnabled(false);
    walkButton.setOnClickListener(this::onPlayAnimation3);

    throwButton = findViewById(R.id.Throw);
    throwButton.setEnabled(false);
    throwButton.setOnClickListener(this::onPlayAnimation4);
  }

  private void onPlayAnimation(View unusedView) {
    if (animator == null || !animator.isRunning()) {
      AnimationData data = andyRenderable.getAnimationData(0);
      nextAnimation = (nextAnimation + 1) % andyRenderable.getAnimationDataCount();
      animator = new ModelAnimator(data, andyRenderable);
      animator.start();
      Toast toast = Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT);
      Log.d(
          TAG,
          String.format(
              "Starting animation %s - %d ms long", data.getName(), data.getDurationMs()));
      toast.setGravity(Gravity.CENTER, 0, 0);
      toast.show();
    }
  }
  private void onPlayAnimation1(View unusedView) {
    if (animator == null || !animator.isRunning()) {
      AnimationData data = andyRenderable.getAnimationData(2);
      nextAnimation = (nextAnimation + 1) % andyRenderable.getAnimationDataCount();
      animator1 = new ModelAnimator(data, andyRenderable);
      animator1.start();
      Toast toast = Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT);
      Log.d(
              TAG,
              String.format(
                      "Starting animation %s - %d ms long", data.getName(), data.getDurationMs()));
      toast.setGravity(Gravity.CENTER, 0, 0);
      toast.show();
    }
  }
  private void onPlayAnimation2(View unusedView) {
    if (animator == null || !animator.isRunning()) {
      AnimationData data = andyRenderable.getAnimationData(1);
      nextAnimation = (nextAnimation + 1) % andyRenderable.getAnimationDataCount();
      animator2 = new ModelAnimator(data, andyRenderable);
      animator2.start();
      Toast toast = Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT);
      Log.d(
              TAG,
              String.format(
                      "Starting animation %s - %d ms long", data.getName(), data.getDurationMs()));
      toast.setGravity(Gravity.CENTER, 0, 0);
      toast.show();
    }
  }

  private void onPlayAnimation3(View unusedView) {
    if (animator == null || !animator.isRunning()) {
      AnimationData data = andyRenderable.getAnimationData(3);
      nextAnimation = (nextAnimation + 1) % andyRenderable.getAnimationDataCount();
      animator2 = new ModelAnimator(data, andyRenderable);
      animator2.start();
      Toast toast = Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT);
      Log.d(
              TAG,
              String.format(
                      "Starting animation %s - %d ms long", data.getName(), data.getDurationMs()));
      toast.setGravity(Gravity.CENTER, 0, 0);
      toast.show();
    }
  }

  private void onPlayAnimation4(View unusedView) {
    if (animator == null || !animator.isRunning()) {
      AnimationData data = andyRenderable.getAnimationData(4);
      nextAnimation = (nextAnimation + 1) % andyRenderable.getAnimationDataCount();
      animator2 = new ModelAnimator(data, andyRenderable);
      animator2.start();
      Toast toast = Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT);
      Log.d(
              TAG,
              String.format(
                      "Starting animation %s - %d ms long", data.getName(), data.getDurationMs()));
      toast.setGravity(Gravity.CENTER, 0, 0);
      toast.show();
    }
  }


  /*
   * Used as the listener for setOnTapArPlaneListener.
   */
  private void onPlaneTap(HitResult hitResult, Plane unusedPlane, MotionEvent unusedMotionEvent) {
    if (andyRenderable == null) {
      return;
    }
    /*if (handRenderable == null){
      return;
    }*/
    // Create the Anchor.
    Anchor anchor = hitResult.createAnchor();

    if (anchorNode == null) {
      anchorNode = new AnchorNode(anchor);
      anchorNode.setParent(arFragment.getArSceneView().getScene());
      andy = new SkeletonNode();
      andy.setParent(anchorNode);
      andy.setRenderable(andyRenderable);
      /*Node andy1 = new Node();
      andy1.setParent(andy);
      andy.setBoneAttachment(HAT_BONE_NAME, andy1);
      Node hand = new Node();
      hand.setParent(andy1);
      hand.setRenderable(handRenderable);
      hand.setWorldScale(Vector3.one());
      hand.setWorldRotation(Quaternion.identity());
      Vector3 pos = hand.getWorldPosition();
      //pos.y=-0.1f;
      hand.setWorldPosition(pos);*/
      //hatNode = new Node();

    }
  }
  /**
   * Called on every frame, control the state of the buttons.
   *
   * @param unusedframeTime
   */
  private void onFrameUpdate(FrameTime unusedframeTime) {
    // If the model has not been placed yet, disable the buttons.
    if (anchorNode == null) {
      if (animationButton.isEnabled()) {
        animationButton.setBackgroundTintList(ColorStateList.valueOf(android.graphics.Color.GRAY));
        animationButton.setEnabled(false);
        handButton.setBackgroundTintList(ColorStateList.valueOf(android.graphics.Color.GRAY));
        handButton.setEnabled(false);
        runButton.setBackgroundTintList(ColorStateList.valueOf(android.graphics.Color.GRAY));
        runButton.setEnabled(false);
        walkButton.setBackgroundTintList(ColorStateList.valueOf(android.graphics.Color.GRAY));
        walkButton.setEnabled(false);
        throwButton.setBackgroundTintList(ColorStateList.valueOf(android.graphics.Color.GRAY));
        throwButton.setEnabled(false);
      }
      } else {
        if (!animationButton.isEnabled()) {
          animationButton.setBackgroundTintList(
                  ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorAccent)));
          animationButton.setEnabled(true);
          handButton.setBackgroundTintList(
                  ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorAccent)));
          handButton.setEnabled(true);
          runButton.setBackgroundTintList(
                  ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorAccent)));
          runButton.setEnabled(true);
          walkButton.setBackgroundTintList(
                  ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorAccent)));
          walkButton.setEnabled(true);
          throwButton.setBackgroundTintList(
                  ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorAccent)));
          throwButton.setEnabled(true);
        }
        //hatButton.setEnabled(true);
        //hatButton.setBackgroundTintList(
      }      //ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorPrimary)));
  }

  void setRenderable(int id, ModelRenderable renderable) {
    if (id == ANDY_RENDERABLE) {
      this.andyRenderable = renderable;
    }
    /*else if (id == HAND_RENDERABLE){
      this.handRenderable = renderable;
    }*/
    /*else {
      this.hatRenderable = renderable;
    }*/
  }

  void onException(int id, Throwable throwable) {
    Toast toast = Toast.makeText(this, "Unable to load renderable: " + id, Toast.LENGTH_LONG);
    toast.setGravity(Gravity.CENTER, 0, 0);
    toast.show();
    Log.e(TAG, "Unable to load andy renderable", throwable);
  }
}
