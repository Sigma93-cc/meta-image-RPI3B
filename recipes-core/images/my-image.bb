SUMMARY = "my-image recipe"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb
IMAGE_BOOT_FILES:append = " waveshare35b-v2.dtbo;overlays/waveshare35b-v2.dtbo"

IMAGE_INSTALL:append = " \
    kernel-module-ads7846 \
    coreutils \
    util-linux \
    bash \
    findutils \
    grep \
    sed \
    gawk \
    procps \
    qtbase \
    qtbase-plugins \
    boost \
    systemanalyzer \
    qtfbsettings \
    swupdate \
    swupdate-hwrevision \
    libubootenv-bin \
    u-boot \    
"

IMAGE_FSTYPES:append = " wic ext4.gz"
IMAGE_FSTYPES:remove = "ext3"
WKS_FILE = "image.wks"

ROOTFS_POSTPROCESS_COMMAND += "add_custom_fstab;"

add_custom_fstab() {
    cat >> ${IMAGE_ROOTFS}/etc/fstab <<EOF
/dev/mmcblk0p1   /boot   vfat    defaults    0  2
/dev/mmcblk0p4   /data   ext4    defaults    0  2
EOF
}